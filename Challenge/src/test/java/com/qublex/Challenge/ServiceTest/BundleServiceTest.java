package com.qublex.Challenge.ServiceTest;

import com.qublex.Challenge.Service.BundleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.qublex.Challenge.Service.BundleServiceImpl.updateFinishedBundlesNumber;
import static com.qublex.Challenge.Utils.readItemList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
public class BundleServiceTest {

    @Autowired
    private BundleService bundleService;

    static Stream<Arguments> updateFinishedBundleNumberData() throws IOException {
        HashMap<String, Object> testCases = readItemList("UpdateFinishedBundleNumberData.json");
        return testCases.values().stream().map(testCase -> {
            Map<String, Object> testCaseMap = (Map<String, Object>) testCase;
            return Arguments.of(
                    testCaseMap.get("stock"),
                    testCaseMap.get("sparePartsNumber"),
                    testCaseMap.get("previousFinishedBundlesNumber"),
                    testCaseMap.get("expectedFinishedBundlesNumber")
            );
        });

    }

    static Stream<Arguments> BundleTreeData() throws IOException {
        HashMap<String, Object> testCases = readItemList("CalculateMaxNumberTest.json");
        return testCases.values().stream().map(testCase -> {
            Map<String, Object> testCaseMap = (Map<String, Object>) testCase;
            return Arguments.of(
                    testCaseMap.get("description"),
                    testCaseMap.get("bundleDesignation"),
                    testCaseMap.get("expectedResult")
            );

        });
    }

    @ParameterizedTest
    @MethodSource("updateFinishedBundleNumberData")
    void calculateMaxNumberTest(int stock,
                                int sparePartsNumber,
                                int previousFinishedBundlesNumber,
                                int expectedFinishedBundlesNumber) {

        int finishedBundles = updateFinishedBundlesNumber(stock, sparePartsNumber, previousFinishedBundlesNumber);
        assertEquals(expectedFinishedBundlesNumber, finishedBundles);
    }

    @ParameterizedTest
    @MethodSource("BundleTreeData")
    void calculateMaxBundleNumberTest(String description, String bundleDesignation, String expectedResult) throws Exception {
        log.info(description);
        int results = bundleService.calculateMaxBundleNumber(bundleDesignation);
        assertEquals(expectedResult, String.valueOf(results));
    }
}