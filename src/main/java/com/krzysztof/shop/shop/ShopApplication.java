package com.krzysztof.shop.shop;

import com.krzysztof.shop.shop.model.*;
import com.krzysztof.shop.shop.repository.UserReposiotry;
import com.krzysztof.shop.shop.security.ApplicationUserRole;
import com.krzysztof.shop.shop.service.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserReposiotry.class)
public class ShopApplication implements ApplicationRunner {


    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private  final UserService userService;
    private  final BasketService basketService;
    private final ProductOrderToBasketService productOrderToBasketService;
    private final AddressService addressService;

    public ShopApplication(AuthorService authorService, CategoryService categoryService, ProductService productService, UserService userService, BasketService basketService, ProductOrderToBasketService productOrderToBasketService, AddressService addressService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.basketService = basketService;
        this.productOrderToBasketService = productOrderToBasketService;
        this.addressService = addressService;
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

        Category homeAppliances = new Category("HomeAppliances");
        Category ovens = new Category("ovens", homeAppliances);
        Category refrigerators = new Category("refrigerators", homeAppliances);

        Category lighting = new Category("lighting");
        Category ceilingLighting = new Category("Ceiling lighting", lighting);
        Category wallLighting = new Category("Wall lighting", lighting);

        if (categoryList.size() == 0) {
            categoryService.save(furniture);
            categoryService.save(armchairs);
            categoryService.save(wardrobes);
            categoryService.save(lawson);
            categoryService.save(club);
            categoryService.save(wood);
            categoryService.save(composite);
            categoryService.save(homeAppliances);
            categoryService.save(ovens);
            categoryService.save(refrigerators);
            categoryService.save(lighting);
            categoryService.save(ceilingLighting);
            categoryService.save(wallLighting);
        }


    }
}
