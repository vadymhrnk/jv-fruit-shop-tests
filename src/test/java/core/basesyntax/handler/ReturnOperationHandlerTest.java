package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReturnOperationHandlerTest {
    private static final String APPLE = "apple";
    private static ReturnOperationHandler returnOperationHandler;

    @BeforeAll
    static void beforeAll() {
        returnOperationHandler = new ReturnOperationHandler();
    }

    @Test
    void handle_validData_ok() {
        Storage.FRUITS.put(APPLE, 20);
        boolean expectedResult = returnOperationHandler.handle(APPLE, 20);
        Assertions.assertTrue(expectedResult);
        Integer expectedQuantity = Storage.FRUITS.get(APPLE);
        Assertions.assertEquals(expectedQuantity, 40);
    }

    @AfterEach
    void tearDown() {
        Storage.FRUITS.clear();
    }
}
