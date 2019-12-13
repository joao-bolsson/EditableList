package model;

/**
 * Interface to define how information will be recovered from their implementations. This interface generalizes the use
 * of ItemPanel.
 *
 * @version 2019, Dec 06.
 */
public interface ItemConfiguration {

    /**
     * @return The title to show on the ItemPanel.
     */
    String getTitle();

    /**
     * @return The
     */
    String getDescription();

}
