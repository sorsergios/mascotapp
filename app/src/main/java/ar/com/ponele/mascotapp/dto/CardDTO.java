package ar.com.ponele.mascotapp.dto;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "losts")
public class CardDTO {
    private String pkey;
    private String name;
    private String phone;
    private String type;

    @DynamoDBHashKey(attributeName = "pkey")
    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DynamoDBAttribute(attributeName = "phone")
    public String getPhone() {
        return phone;
    }

    public void setType(String type) {
        this.type = type;
    }

    @DynamoDBAttribute(attributeName = "type")
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " " + phone + " " + type;
    }
}
