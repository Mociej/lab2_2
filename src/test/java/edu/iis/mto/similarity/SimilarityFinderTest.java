package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.fail;

import edu.iis.mto.searcher.Mock;
import edu.iis.mto.searcher.SearchResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimilarityFinderTest {
    public static SimilarityFinder similarityFinder;
    int [] seq1;
    @Test
    void test() {
        similarityFinder=new SimilarityFinder(new Mock());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateJackardSimilarity() {
    }


}
