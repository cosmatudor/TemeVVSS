package org.example.pages;

import net.thucydides.core.pages.PageObject;

import static junit.framework.TestCase.assertEquals;

public class ProductsPage extends PageObject {

    public void addFirstProductToCart( ) {
        $( ".inventory_item button" ).click( ); // adaugă primul produs
    }

    public void goToCart( ) {
        $( ".shopping_cart_link" ).click( );
    }

    public void shouldBeOnProductsPage( ) {
        String actualTitle = $( ".title" ).getText( );
        assertEquals( "Page title should be 'Products'", actualTitle, "Products" );
    }

    public void cartBadgeShouldShow( String expectedCount ) {
        String actualCount = $( ".shopping_cart_badge" ).getText( );
        assertEquals(  "Cart badge count mismatch", expectedCount, actualCount );
    }
}
