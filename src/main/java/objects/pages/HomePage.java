package objects.pages;

import objects.widgets.categories.CategoriesList;
import objects.widgets.categories.CategoriesSection;
import objects.widgets.NavBar;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

    private String url = "https://www.demoblaze.com/index.html";
    private CategoriesList categoriesList;
    private CategoriesSection categoriesSection;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        categoriesList = new CategoriesList(webDriver);
        categoriesSection = new CategoriesSection(webDriver);
    }

    public NavBar getNavBar() {
        return navBar;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public CategoriesList getCategoriesList() {
        return categoriesList;
    }

    public CategoriesSection getCategoriesSection() {
        return categoriesSection;
    }
}
