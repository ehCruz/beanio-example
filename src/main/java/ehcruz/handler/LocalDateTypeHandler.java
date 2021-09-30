package ehcruz.handler;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTypeHandler implements TypeHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("ddMMyyyy");

    @Override
    public Object parse(String s) throws TypeConversionException {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        try {
            return LocalDate.parse(s, FORMATTER);
        } catch (Exception ex) {
            throw new TypeConversionException(ex);
        }
    }

    @Override
    public String format(Object o) {
        if(o == null)  return null;
        LocalDate l = (LocalDate)o;
        return l.format(FORMATTER);
    }

    @Override
    public Class<?> getType() {
        return LocalDate.class;
    }
}
