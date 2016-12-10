package com.pms.kirillbaranov.premierleague.ui.helper;

/**
 * Created by KirillBaranov on 10.12.16.
 */

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

/**
 * Convert the {@link SVG}'s internal representation to an Android-compatible one ({@link Picture}).
 */
public class SvgDrawableTranscoder implements ResourceTranscoder<SVG, PictureDrawable> {
    @Override
    public Resource<PictureDrawable> transcode(Resource<SVG> toTranscode) {
        SVG svg = toTranscode.get();
        try {
            svg.setDocumentViewBox(0, 0, svg.getDocumentWidth(), svg.getDocumentHeight());
            svg.setDocumentWidth("100%");
            svg.setDocumentHeight("100%");
        } catch (SVGParseException e) {
            e.printStackTrace();
        }

        Picture picture = svg.renderToPicture();
        PictureDrawable drawable = new PictureDrawable(picture);
        return new SimpleResource<PictureDrawable>(drawable);
    }

    @Override
    public String getId() {
        return "";
    }
}
