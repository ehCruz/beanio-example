package ehcruz.model;

import ehcruz.handler.LocalDateTypeHandler;
import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.beanio.internal.util.TypeHandlerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MarshallEmployeeTest {

    private static Marshaller marshaller;

    @BeforeAll
    public static void init() {
        StreamFactory factory = StreamFactory.newInstance();

        StreamBuilder builder = new StreamBuilder("")
                .format("fixedlength")
                .parser(new FixedLengthParserBuilder())
                .addTypeHandler("localDateHandler", new LocalDateTypeHandler())
                .addRecord(Employee.class);
        factory.define(builder);

        marshaller = factory.createMarshaller("");
    }

    @Test
    void marshallEmployeeObject() {
        Employee employee = new Employee();
        employee.setFisrtName("Eduardo Henrique");
        employee.setLastName("Cruz");
        employee.setPosition("Developer");
        employee.setHireDate(LocalDate.now());
        employee.setSalary(new BigDecimal("1600.00"));

        String marshallObjcet = marshaller.marshal(employee).toString();

        Assertions.assertNotNull(marshallObjcet);
        Assertions.assertEquals("Eduardo Henrique        Cruz      Developer      2909202100000000000160000", marshallObjcet);
    }

}
