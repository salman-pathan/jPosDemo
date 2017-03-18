package common;

/**
 * jPosDemo
 * Created by Salman Khan on 3/18/2017.
 */
public class AppConstant {
    public static final String SCHEMA_PATH = "src/main/resources/message_schema.xml";

    public enum DE {
        SECONDARY_BITMAP(1),
        PAN(2),
        PROCESSING_CODE(3),
        TRANSACTION_AMOUNT(4),
        TRANSACTION_DATE_TIME(7);

        private final int elementIndex;
        DE(final int index) {elementIndex = index;}
        public int getElementIndex() {return elementIndex;}
    }
}
