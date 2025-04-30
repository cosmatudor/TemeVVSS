package org.example.pages;

import net.thucydides.core.pages.PageObject;

import static junit.framework.TestCase.assertTrue;

public class CartPage extends PageObject {
    public void proceedToCheckout( ) {
        $( "#checkout" ).click( );
    }

    public void shouldContainOneProduct( ) {
        try {
            Thread.sleep( 3000 ); // Wait 3 seconds so you can manually click "OK"
        } catch ( InterruptedException e ) {
            e.printStackTrace( );
        }
        boolean isProductVisible = $( ".cart_item" ).isVisible( );
        assertTrue( isProductVisible );
    }
}
