package com.josem111.ui.data;

import com.josem111.R;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Data {
    private final String value;
    private final int image;

    public Data(String value, int image) {
        this.value = value;
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public int getImage() {
        return image;
    }

    public static List<Data> getDataList() {
        List<Data> dataList;
        String[] values = {
                "Java", "CSS3", "Android", "jQuery", "PHP", "MySpace",
                "HTML5", "Javascript", "MySQL", "Python", "Swift",
                "WordPress", "Facebook", "Youtube", "Twitter"
        };

        int[] images = {
                R.drawable.image7, R.drawable.image2,
                R.drawable.image3, R.drawable.image4,
                R.drawable.image5, R.drawable.image6,
                R.drawable.image7, R.drawable.image8,
                R.drawable.image9, R.drawable.image10,
        };

        dataList = IntStream.range(0, values.length).mapToObj(i -> {
            return new Data(values[i], images[i % images.length]);
        }).collect(Collectors.toList());

        return dataList;
    }
}
