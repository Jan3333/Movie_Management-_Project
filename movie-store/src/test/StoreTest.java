package src.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Movie;
import src.main.models.Store;

public class StoreTest {

    Store store;

    @Before
    public void setup(){
            store = new Store();
            store.addMovie(new Movie("Dragon Fist","DVD",8));
            store.addMovie(new Movie("The Witches","DVD",7));
    }

    @Test
    public void MovieAddedTest() {
        assertTrue(store.contains(new Movie("The Witches","DVD",7)));
    }

    @Test 
    public void sellMovieTest() {
        store.sellMovie("Dragon Fist");
        assertFalse(store.contains(new Movie("Dragon Fist","DVD",8)));
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("The Witches");
        assertFalse(store.getMovie(1).isAvailable());
    }

    @Test
    public void returnMovieTest() {
        store.returnMovie("The Witches");
        assertTrue(store.getMovie(1).isAvailable());

    }

    @Test(expected = IllegalStateException.class)
    public void movieNotInStock() {
        store.rentMovie("The Witches");
        store.sellMovie("The Witches");
    }




}
