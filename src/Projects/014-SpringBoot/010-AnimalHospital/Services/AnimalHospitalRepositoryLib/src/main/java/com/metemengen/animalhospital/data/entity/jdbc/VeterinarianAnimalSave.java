package com.metemengen.animalhospital.data.entity.jdbc;

public class VeterinarianAnimalSave {
    public int animalId;
    public long diplomaNo;

    public double price;

    public int getAnimalId()
    {
        return animalId;
    }

    public void setAnimalId(int animalId)
    {
        this.animalId = animalId;
    }

    public long getDiplomaNo()
    {
        return diplomaNo;
    }

    public void setDiplomaNo(long diplomaNo)
    {
        this.diplomaNo = diplomaNo;
    }


    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
