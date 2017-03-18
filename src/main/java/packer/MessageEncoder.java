package packer;

import common.AppConstant;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.util.Date;

/**
 * jPosDemo
 * Created by Salman on 3/18/2017.
 */
public class MessageEncoder {

    ISOMsg _isoMsg;
    public MessageEncoder() {
        packMessage();
    }

    private void packMessage() {
        try {
            //  Creates packager based on the XML schema, which container data elements.
            GenericPackager packager = new GenericPackager(AppConstant.SCHEMA_PATH);

            //  ISO Message for Transaction.
            _isoMsg = new ISOMsg();
            _isoMsg.setMTI("0200");  //Request for funds.

            //  Set Data Elements
            _isoMsg.setPackager(packager);
            _isoMsg.set(AppConstant.DE.SECONDARY_BITMAP.getElementIndex(), "0");
            _isoMsg.set(AppConstant.DE.PAN.getElementIndex(), "32DAGH5H");
            _isoMsg.set(AppConstant.DE.PROCESSING_CODE.getElementIndex(), "TC5478");
            _isoMsg.set(AppConstant.DE.TRANSACTION_AMOUNT.getElementIndex(), "2500");
            _isoMsg.set(AppConstant.DE.TRANSACTION_DATE_TIME.getElementIndex(), "22/02/2017");

            logMessage(_isoMsg);

            //  Pack the message
            byte[] packedMessage = _isoMsg.pack();
            System.out.println("PACKED ISO MESSAGE : " + new String(packedMessage));
        } catch (ISOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logMessage(ISOMsg message) {
        try {
            System.out.println("------------------------ ISO MESSAGE ------------------------");
            String mti = message.getMTI();
            System.out.println("    MTI : " + mti);
            for (int index=1; index<=message.getMaxField(); index++) {
                if (message.hasField(index)) {
                    System.out.println("        Data Element : " + message.getString(index));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("------------------------------------------------");
        }
    }

    public ISOMsg getIsoMsg() {
        return _isoMsg;
    }
}
