package parking;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class InOrderParkingStrategyTest {

	@Test
    public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
	    * With using Mockito to mock the input parameter */

        //Mock出虛擬對象
        Car car1 = Mockito.mock(Car.class);
        ParkingLot parkingLot1=Mockito.mock(ParkingLot.class);

        //自定義行爲
        when(car1 .getName()).thenReturn("car1");
        when(parkingLot1.getName()).thenReturn("parkingLot1");

        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        Receipt receipt = inOrderParkingStrategy.createReceipt(parkingLot1,car1);

        Assert.assertEquals("car1",receipt.getCarName());
        Assert.assertEquals("parkingLot1",receipt.getParkingLotName());

    }

    @Test
    public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
         * With using Mockito to mock the input parameter */
        Car car2 = Mockito.mock(Car.class);

        when(car2 .getName()).thenReturn("car2");

        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        Receipt receipt = inOrderParkingStrategy.createNoSpaceReceipt(car2);

        Assert.assertEquals("car2",receipt.getCarName());
        Assert.assertEquals("No Parking Lot",receipt.getParkingLotName());

    }

    @Test
    public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt(){

	    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */

        Car car = Mockito.mock(Car.class);
//        ParkingLot parkingLot=new ParkingLot("parlot1",0);
        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(parkingLot);

        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        Receipt receipt = inOrderParkingStrategy.park(lots, car);

        Mockito.verify(inOrderParkingStrategy).createNoSpaceReceipt(car);
    }

    @Test
    public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */

    }

    @Test
    public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */

    }

    @Test
    public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot(){

        /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */

        Car car = Mockito.mock(Car.class);
        ParkingLot parkingLot1 = new ParkingLot("parkinglot1",0);
        ParkingLot parkingLot2 = new ParkingLot("parkinglot2",2);
        List<ParkingLot> lots= new ArrayList<>();
        lots.add(parkingLot1);
        lots.add(parkingLot2);

        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        Receipt receipt= inOrderParkingStrategy.park(lots,car);

        Mockito.verify(inOrderParkingStrategy,times(1)).createReceipt(parkingLot2,car);
    }


}
