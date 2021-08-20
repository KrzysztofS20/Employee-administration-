package com.krzysztof.shop.shop;

import com.krzysztof.shop.shop.model.Author;
import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.service.AuthorService;
import com.krzysztof.shop.shop.service.CategoryService;
import com.krzysztof.shop.shop.service.ProductService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class ShopApplication implements ApplicationRunner {


    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public ShopApplication(AuthorService authorService, CategoryService categoryService, ProductService productService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Author> authorList = authorService.findAll();
        Author author1 = new Author("Jan", "Kowalski");
        Author author2 = new Author("Krzysztof", "Kula");
        Author author3 = new Author("Kamil", "But");

        if (authorList.size() == 0) {
            authorService.saveAuthor(author1);
            authorService.saveAuthor(author2);
            authorService.saveAuthor(author3);
        }

        List<Category> categoryList = categoryService.findAll();
        Category furniture = new Category("Furniture");
        Category armchairs = new Category("Armchairs", furniture);
        Category wardrobes = new Category("Wardrobes", furniture);
        Category lawson = new Category("Lawson", armchairs);
        Category club = new Category("Club", armchairs);
        Category wood = new Category("Wood", wardrobes);
        Category composite = new Category("Composite", wardrobes);

        Category homeAppliances = new Category("Home appliances");
        Category ovens = new Category("ovens", homeAppliances);
        Category refrigerators = new Category("refrigerators", homeAppliances);

        Category lighting = new Category("lighting");
        Category ceilingLighting = new Category("Ceiling lighting", lighting);
        Category wallLighting = new Category("Wall lighting", lighting);

        if (categoryList.size() == 0) {
            categoryService.saveCategory(furniture);
            categoryService.saveCategory(armchairs);
            categoryService.saveCategory(wardrobes);
            categoryService.saveCategory(lawson);
            categoryService.saveCategory(club);
            categoryService.saveCategory(wood);
            categoryService.saveCategory(composite);
            categoryService.saveCategory(homeAppliances);
            categoryService.saveCategory(ovens);
            categoryService.saveCategory(refrigerators);
            categoryService.saveCategory(lighting);
            categoryService.saveCategory(ceilingLighting);
            categoryService.saveCategory(wallLighting);
        }

        List<Product> productList = productService.findAll();
        Product lawsonBlue = new Product("Blue Lawson Armchair","It's blue and nice","",200.00,author1,lawson);
        Product lawsonRed = new Product("Red Lawson Armchair","It's red and comfortable","",210.99,author1,lawson);
        Product clubBrown = new Product("Red Club Armchair","It's nice armchair","",150.00,author1,club);
        Product clubBlue = new Product("Blue Club Armchair","It's just blue","",149.99,author2,club);
        Product darkWoodWardrobe = new Product("Dark Wood Wardrobe","It's just wardrobe","",199.00,author2,wood);
        Product birchWoodWardrobe = new Product("Birch Wood Wardrobe","It's just wardrobe","",160.00,author2,wood);
        Product compositeWardrobe = new Product("Composite Wardrobe","It's just wardrobe","",149.99,author2,composite);
        Product blackOven = new Product("Black Oven","Oven like from The Sims","",300.99,author3,ovens);
        Product blackRefrigerators = new Product("Black Refrigerators","Small Refrigerators","",290.99,author3,refrigerators);
        Product singleCeilingLight = new Product("Single CeilingLight","Small","",90.99,author3,ceilingLighting);
        Product singleWallLight = new Product("Single WallLight","Small","",90.99,author3,wallLighting);

        if(productList.size()==0){
            productService.saveProduct(lawsonBlue);
            productService.saveProduct(lawsonRed);
            productService.saveProduct(clubBrown);
            productService.saveProduct(clubBlue);
            productService.saveProduct(darkWoodWardrobe);
            productService.saveProduct(birchWoodWardrobe);
            productService.saveProduct(compositeWardrobe);
            productService.saveProduct(blackOven);
            productService.saveProduct(blackRefrigerators);
            productService.saveProduct(singleCeilingLight);
            productService.saveProduct(singleWallLight);
        }

    }
}
