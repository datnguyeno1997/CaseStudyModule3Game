package controrler;

import appconfig.AppConfig;

import model.*;
import service.*;
import untils.ValidatesUntils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "C:\\codegym\\Module3\\ProductManager\\src\\main\\webapp\\frontend\\assets\\images";
    private IProductService productService = new ProductServiceMysql();
    private IProductTypeService productTypeService = new ProductTypeServiceMysql();

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(req, resp);
                break;
            case "edit":
                showEdit(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                showList(req, resp);

        }

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        productService.remove(id);

        req.getSession().setAttribute("messageDelete", "Xóa thành công");
        resp.sendRedirect("/products");
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idProduct = Long.parseLong(req.getParameter("id"));

        Product product = productService.findById(idProduct);
        req.setAttribute("product", product);

        List<ProductType> productTypes = productTypeService.findAll();
        req.setAttribute("productTypes", productTypes);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard/products/edit.jsp");

        req.setAttribute("sizes", ESize.values());
        requestDispatcher.forward(req, resp);

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pageable pageable = new Pageable();
        readPageable(req,pageable);

        productService.findProducts(pageable);
        User user = (User) req.getSession().getAttribute("user");


        List<Product> productList = productService.findProducts(pageable);
        req.setAttribute("products", productList);
        req.setAttribute("pageable", pageable);


        List<ProductType> productTypes = productTypeService.findAll();
        req.setAttribute("productTypes", productTypes);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "products/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void readPageable(HttpServletRequest req, Pageable pageable) {
        String kw = "";
        if (req.getParameter("kw") != null){
            kw = req.getParameter("kw");

        }
        pageable.setKw(kw);
        int productType = -1;
        if (req.getParameter("product-type") != null){
            productType = Integer.parseInt(req.getParameter("product-type"));

        }
        pageable.setProductType(productType);
        int page = 1;
        if (req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));

        }
        pageable.setPage(page);
        int limit = 5;
        if (req.getParameter("limit") != null){
            limit = Integer.parseInt(req.getParameter("limit"));

        }
        pageable.setLimit(limit);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductType> productTypes = productTypeService.findAll();

        req.setAttribute("productTypes", productTypes);
//        req.setAttribute("sizes", ESize.values());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard/products/create.jsp");
        req.setAttribute("sizes", ESize.values());

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveProduct(req, resp);
                break;
            case "edit":
                try {
                    updateProduct(req, resp);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, URISyntaxException {
        Product product = new Product();
        List<String> errors = new ArrayList<>();
        validateIdProduct(req, product, errors);
        validateName(req, product, errors);
        validateDescription(req,product, errors);
        validatePrice(req, product, errors);
        validateProductType(req, product, errors);
        validateCreateAt(req, product, errors);

        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String img = req.getParameter("img");

        String fileName = "\\dashboard\\asset\\assets\\images\\" + img;

        String file = fileName.replace("\\","/");

        product.setQuantity(quantity);
        product.setImg(file);

//
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate createAt = LocalDate.parse(req.getParameter("createAt"), DATEFORMATTER);

        LocalDate now = LocalDate.now();


        product.setCreateAt(createAt);
        product.setUpdateAt(now.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC));

        if(!errors.isEmpty()){
            req.setAttribute("errors", errors);
            req.setAttribute("product", product);

            List<ProductType> productTypes = productTypeService.findAll();
            req.setAttribute("productTypes", productTypes);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard/products/edit.jsp");

            requestDispatcher.forward(req, resp);

        }
        else {
            productService.update(product.getId(), product);
            req.getSession().setAttribute("messageEdit", "Sửa thành công");
            resp.sendRedirect("/products");            // Dùng respone để sendRedirect
        }

    }

    private void validateCreateAt(HttpServletRequest req, Product product, List<String> errors) {
    }

    private void saveProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        List<String> errors = new ArrayList<>();

        validateName(req, product, errors);
        validateDescription(req,product, errors);
        validatePrice(req, product, errors);
        validateProductType(req, product, errors);

        LocalDate createAt = LocalDate.now();
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String img = req.getParameter("img");

        String fileName = "\\dashboard\\asset\\assets\\images\\" + img;


        String file = fileName.replace("\\","/");

        product.setQuantity(quantity);
        product.setImg(file);

        product.setCreateAt(createAt);
        product.setUpdateAt(createAt.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC));

        List<ProductType> productTypes = productTypeService.findAll();
        req.setAttribute("productTypes", productTypes);

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("product", product);
        }else{
            req.setAttribute("message", "Thêm thành công");
            productService.save(product);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard/products/create.jsp");
        requestDispatcher.forward(req, resp);

    }
    private void validateIdProduct(HttpServletRequest req, Product product, List<String> errors) {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            if (productService.findById(id) == null){
                errors.add("Mã sản phẩm không hợp lệ");
            }
            product.setId(id);
        }catch (NumberFormatException numberFormatException){
            errors.add("Định dạng mã sản phẩm không hợp lệ");
        }
    }
    private void validateProductType(HttpServletRequest req, Product product, List<String> errors){
        ProductType pt = null;
        try {
            // idCate có 2 trường hợp: "aaa" hoặc mã ko hợp lệ ko có trong DB 20000
            int idCate = Integer.parseInt(req.getParameter("product-type"));
            pt = productTypeService.findById(idCate);
            if(pt == null){
                errors.add("Loại sản phẩm không có trong CSDL");
            }

        }catch (NumberFormatException numberFormatException){
            errors.add("Định dạng loại sản phẩm không hợp lệ");
        }
        product.setProductType(pt);
    }
    private void validateName(HttpServletRequest req, Product product, List<String> errors){
        String name = req.getParameter("name");
        if(!ValidatesUntils.isUserNameValid(name)){
            errors.add("Tên không hợp lệ, bắt đầu bằng chữ cái và phải có từ 8-20 kí tự");
        }
        product.setName(name);
    }
    private void validateDescription(HttpServletRequest req, Product product, List<String> errors){
        String description = req.getParameter("description");
        if (!ValidatesUntils.isValidDescription(description)){
            errors.add("Mô tả không hợp lệ,bắt đầu bằng chữ cái và số phải có từ 8-49 kí tự");
        }
        product.setDescription(description);
    }
    private void validatePrice(HttpServletRequest req, Product product, List<String> errors){
        String priceParameter = req.getParameter("price");
        if (priceParameter != null && !priceParameter.isEmpty()){
            try {
                BigDecimal price = new BigDecimal(priceParameter);
                product.setPrice(price);
                if (price.compareTo(BigDecimal.ZERO) <= 0){
                    errors.add("Giá sản phẩm phải lớn hơn 0");
                }
            }catch (NumberFormatException numberFormatException){
                errors.add("Giá sản phẩm không hợp lệ");
            }
        }else {
            errors.add("Giá sản phẩm không được bỏ trống");
        }

    }

}