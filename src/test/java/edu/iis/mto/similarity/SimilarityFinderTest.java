package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.fail;

import edu.iis.mto.searcher.Mock;
import edu.iis.mto.searcher.SearchResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityFinderTest {

    static public int[] seq1;
    static public int[] seq2;
    public Mock mock;
    public SimilarityFinder similarityFinder;

    @BeforeEach
    void init() {
        mock = new Mock();
        similarityFinder = new SimilarityFinder(mock);
        seq1= new int[] {1,4,56,8};
        seq2= new int[] {2,4,55,7};
    }

    @Test
    void test() {

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateJackardSimilarityFirstNull() {
        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(null, seq2));
    }
    @Test
    void calculateJackardSimilaritySecondNull() {
        assertThrows(IllegalArgumentException.class, () -> similarityFinder.calculateJackardSimilarity(seq1, null));
    }
    @Test
    void calculateJackardSimilarityBothNull() {
        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(null, null));
    }


}
