package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SupplyOperationHandlerTest {
    private static final String APPLE = "apple";
    private static SupplyOperationHandler supplyOperationHandler;

    @BeforeAll
    static void beforeAll() {
        supplyOperationHandler = new SupplyOperationHandler();
    }

    @Test
    void handle_validData_ok() {
        Storage.FRUITS.put(APPLE, 20);
        boolean expectedResult = supplyOperationHandler.handle(APPLE, 20);
        Assertions.assertTrue(expectedResult);
        Integer expectedQuantity = Storage.FRUITS.get(APPLE);
        Assertions.assertEquals(expectedQuantity, 40);
    }

    @AfterEach
    void tearDown() {
        Storage.FRUITS.clear();
    }
}
