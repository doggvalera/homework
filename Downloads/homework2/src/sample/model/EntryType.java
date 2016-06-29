package sample.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum(String.class)
public enum EntryType {
    MOBILE_PHONE,
    HOME_PHONE,
    EMAIL,
    HOME_ADDRESS,

}
