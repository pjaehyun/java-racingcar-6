package racingcar;

import car.Car;
import car.CarCollection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarCollectionTest {

    @Test
    void addCar_자동차_추가() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        CarCollection carCollection = createCarCollection(car1, car2);

        List<Car> cars = carCollection.getCars();

        assertThat(cars).contains(car1);
        assertThat(cars).contains(car2);
    }

    @Test
    void moveCarsForward_모든_자동차_앞으로_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");
                    Car car3 = new Car("car3");

                    CarCollection carCollection = createCarCollection(car1, car2, car3);

                    carCollection.moveCarsForward();

                    List<Car> cars = carCollection.getCars();
                    for(Car car : cars) {
                        assertThat(car.getDistance()).isEqualTo(1);
                    }
                },
                4, 4, 4
        );
    }

    private CarCollection createCarCollection(Car... cars) {
        CarCollection carCollection = new CarCollection();

        for (Car car : cars) {
            carCollection.addCar(car);
        }
        return carCollection;
    }
}
