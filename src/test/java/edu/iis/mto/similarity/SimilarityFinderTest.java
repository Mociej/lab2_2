package edu.iis.mto.similarity;

import edu.iis.mto.searcher.SearchResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityFinderTest {

    static public int[] seq1;
    static public int[] seq2;
    static public int[] seqEmpty;

    public SimilarityFinder similarityFinder;

    @BeforeEach
    void init() {
        seq1= new int[] {1,4,56,8};
        seq2= new int[] {2,4,55,7};
        seqEmpty= new int[] {};
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
        similarityFinder = new SimilarityFinder((elem, sequence) -> SearchResult.builder()
                .withFound(false)
                .build());

        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(null, seq2));
    }
    @Test
    void calculateJackardSimilaritySecondNull() {
        similarityFinder = new SimilarityFinder((elem, sequence) -> SearchResult.builder()
                .withFound(false)
                .build());
        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(seq1, null));
    }
    @Test
    void calculateJackardSimilarityBothNull() {
        similarityFinder = new SimilarityFinder((elem, sequence) -> SearchResult.builder()
                .withFound(false)
                .build());
        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(null, null));
    }
    @Test
    void calculateJackardSimilarityFirstEmpty() {
        SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> null);
        assertEquals(0, similarityFinder.calculateJackardSimilarity(seqEmpty, seq1));
    }

    @Test
    void calculateJackardSimilaritySecondEmpty() {
        similarityFinder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(false).build());

        assertEquals(0, similarityFinder.calculateJackardSimilarity(seq1, seqEmpty));
    }

    @Test
    void calculateJackardSimilarityBothEmpty() {
        similarityFinder = new SimilarityFinder((elem, sequence) -> null);

        assertEquals(1, similarityFinder.calculateJackardSimilarity(seqEmpty, seqEmpty));
    }

    @Test
    void calculateJackardSimilaritySameSeqs() {
        SimilarityFinder similarityFinder = new SimilarityFinder((elem, sequence) -> SearchResult.builder()
                .withFound(true)
                .build());
        assertEquals(1, similarityFinder.calculateJackardSimilarity(seq1, seq1));
    }

    @Test
    void calculateJackardSimilarityNotSameSeqs() {
        similarityFinder = new SimilarityFinder(((elem, sequence) -> SearchResult.builder().withFound(false).build()));
        similarityFinder.calculateJackardSimilarity(seq1, seq1);
        assertEquals(0, similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

}
