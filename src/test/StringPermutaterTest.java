package test;

import com.mc.StringPermutater;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringPermutaterTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void printPermutations_ThrowsException_IfNoArgs() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("No string provided to permutate");
        StringPermutater.printStringPermutations(new String[0]);
    }

    @Test
    public void printPermutations_ThrowsException_IfGreaterThanOneArgs() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Permutation of multiple strings not supported");
        StringPermutater.printStringPermutations(new String[]{"test", "test2", "manyArgs"});
    }

    @Test
    public void permutateString_ReturnsEmptySet_IfEmptyString() {
        Set<String> permutations = StringPermutater.permutateString("");
        assertTrue(permutations.isEmpty());
    }

    @Test
    public void permutateString_ReturnsEmptySet_IfNullString() {
        Set<String> permutations = StringPermutater.permutateString(null);
        assertTrue(permutations.isEmpty());
    }

    @Test
    public void permutateString_ReturnsCorrectSet_IfStringGiven() {
        Set<String> permutations = StringPermutater.permutateString("ABC");
        Set<String> correctPerms = new HashSet<>(Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA"));
        assertTrue(permutations.containsAll(correctPerms));
    }


    @Test
    public void permutateString_ReturnsCorrectSet_IfStringWithMixedCasesAndNumbersGiven() {
        Set<String> permutations = StringPermutater.permutateString("Ab1");
        Set<String> correctPerms = new HashSet<>(Arrays.asList("Ab1", "A1b", "bA1", "b1A", "1Ab", "1bA"));
        assertTrue(permutations.containsAll(correctPerms));
    }

    @Test
    public void permutateString_ReturnsNoDuplicates_IfDuplicateCharStringGiven() {
        Set<String> permutations = StringPermutater.permutateString("AAAAA");
        Set<String> correctPerms = new HashSet<>(Collections.singletonList("AAAAA"));
        assertTrue(permutations.containsAll(correctPerms));
        assertEquals(1, permutations.size());
    }
}
