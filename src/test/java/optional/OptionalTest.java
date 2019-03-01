package optional;

import com.xunhuan.java.model.Car;
import com.xunhuan.java.model.Insurance;
import com.xunhuan.java.model.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * @author tianhuan
 * @date 2018-11-06 14:22
 **/
public class OptionalTest {

    @Test
    public void test01(){
        /*
            声明一个空对象
         */
        Optional<Car> car = Optional.empty();

        /*
            构建非空对象
         */
        Car car1 = new Car();
        car1.setInsurance(Optional.of(new Insurance("lalala")));
        Optional<Car> car2 = Optional.of(car1);
        System.out.println(car2.get().toString());

        /*
            如果传入null则会报错
         */
//        Optional<Car> car3 = Optional.of(null);
//        System.out.println(car3.get());


//        Optional<Insurance> optionalInsurance = Optional.ofNullable(null);
//        Optional<String> s = optionalInsurance.map(Insurance::getName);
//        System.out.println(s);

    }

    public String getCarInsuranceName(Optional<Person> person){

//        return person.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }


    @Test
    public void test02(){
        String carInsuranceName = getCarInsuranceName(Optional.of(new Person(Optional.of(new Car(Optional.of(new Insurance("123")))))));
        System.out.println(carInsuranceName);

        String carInsuranceName2 = getCarInsuranceName(Optional.of(new Person(Optional.of(new Car(Optional.ofNullable(null))))));
        System.out.println(carInsuranceName2);

        Optional<Insurance> optInsurance = Optional.of(new Insurance("CambridgeInsurance"));
        optInsurance.filter(insurance -> "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x -> System.out.println("ok"));

    }

    public Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Test
    public void test03(){
        Optional<Integer> op = stringToInt("123");
        System.out.println(op.orElse(0));
    }

}
