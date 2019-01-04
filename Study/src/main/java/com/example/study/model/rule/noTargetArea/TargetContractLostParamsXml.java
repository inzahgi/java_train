package com.example.study.model.rule.noTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class TargetContractLostParamsXml {

    @XmlElement(name = "updatecycle")
    private UpdateCycleXml updateCycleXml;


    public void setUpdateCycleXml(UpdateCycleXml updateCycleXml){
        this.updateCycleXml = updateCycleXml;
    }

    public UpdateCycleXml getUpdateCycleXml() {
        return updateCycleXml;
    }
}
