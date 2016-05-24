package com.livingfaith.lfc;

import android.graphics.drawable.Drawable;

/**
 * Created by Hanson on 4/13/2016.
 */

/**
 * Created by Hanson on 3/30/2016.
 */
public class GridViewItem_2
{
    String title;
    Drawable image;


    // Constructor
    public GridViewItem_2(String title, Drawable image)
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

    public Drawable getImage()
    {
        return image;
    }

    public void setImage(Drawable image)
    {
        this.image = image;
    }


}

