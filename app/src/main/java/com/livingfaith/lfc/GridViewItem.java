package com.livingfaith.lfc;

/**
 * Created by Hanson on 3/30/2016.
 */
public class GridViewItem
{
    String title;
    int image;



    // Constructor
    public GridViewItem(String title, int image)
    {
        super();
        this.title = title;
        this.image = image;
    }

    // Getter and Setter Method
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getImage()
    {
        return image;
    }

    public void setImage(int image)
    {
        this.image = image;
    }


}