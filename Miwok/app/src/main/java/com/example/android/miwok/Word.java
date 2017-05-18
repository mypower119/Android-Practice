package com.example.android.miwok;

/**
 * Created by TruongVu on 15/5/2017.
 */

public class Word {

    private int mMiwokTranslationId;
    private int mDefaultTranslationId;
    private int mAudioResourceId = NO_IMAGE_AND_AUDIO_PROVIDED;
    private int mImageResourceId = NO_IMAGE_AND_AUDIO_PROVIDED;

    private final static int NO_IMAGE_AND_AUDIO_PROVIDED = -1;

    public Word(int miwokTranslation, int defaultTranslate, int imageResourceId, int audioResourceId) {
        mMiwokTranslationId = miwokTranslation;
        mDefaultTranslationId = defaultTranslate;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public Word(int miwokTranslation, int defaultTranslate, int audioResourceId) {
        mMiwokTranslationId = miwokTranslation;
        mDefaultTranslationId = defaultTranslate;
        mAudioResourceId = audioResourceId;
    }

    public Word(int miwokTranslation, int defaultTranslate) {
        mMiwokTranslationId = miwokTranslation;
        mDefaultTranslationId = defaultTranslate;
    }

    public Word() {
    }

    public int getMiwokTranslationId() {
        return mMiwokTranslationId;
    }

    public void setMiwokTranslation(int miwokTranslationId) {
        mMiwokTranslationId = miwokTranslationId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getDefaultTranslationId() {
        return mDefaultTranslationId;
    }

    public void setDefaultTranslation(int defaultTranslationId) {
        mDefaultTranslationId = defaultTranslationId;
    }

    public int getAudioResourceId () {
        return mAudioResourceId;
    }

    public boolean hasAudio() {
        return mAudioResourceId != NO_IMAGE_AND_AUDIO_PROVIDED;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_AND_AUDIO_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslationId + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslationId + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
