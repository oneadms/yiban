package com.builder.yiban;

public class BuildImageManager {


    private static ImageDetails imageDetails;

    public static ImageDetails getImageDetails() {
        return imageDetails;
    }

    public static void save(ImageDetails imageDetails) {
        BuildImageManager.imageDetails = imageDetails;
    }
}
