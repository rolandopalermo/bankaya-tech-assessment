package mx.com.bankaya.assessment.exceptions;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ServiceFault",
        propOrder = {
                "code",
                "description"
        })
public class ServiceFault {

    private String code;
    private String description;

    public ServiceFault() {
    }

    public ServiceFault(String code, String description) {
        this.code = code;
        this.description = description;
    }

}