/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

public class MonitorsConfig implements ItemConfiguration {

    private String oneMonitor;
    private String twoMonitors;

    /**
     * Default construct.
     */
    public MonitorsConfig() {
        // empty
    }

    /**
     * Creates a monitors configuration accordingly with the given parameters.
     *
     * @param oneMonitor Setting for one monitor.
     * @param twoMonitors Setting for two monitors.
     */
    public MonitorsConfig(final String oneMonitor, final String twoMonitors) {
        this.oneMonitor = oneMonitor;
        this.twoMonitors = twoMonitors;
    }

    /**
     * @return The setting for one monitor.
     */
    public String getOneMonitor() {
        return oneMonitor;
    }

    /**
     * Sets a new value for one monitor setting.
     *
     * @param oneMonitor New value to set.
     */
    public void setOneMonitor(final String oneMonitor) {
        this.oneMonitor = oneMonitor;
    }

    /**
     * @return The setting for two monitors.
     */
    public String getTwoMonitors() {
        return twoMonitors;
    }

    /**
     * Sets a new value for two monitors setting.
     *
     * @param twoMonitors New value to set.
     */
    public void setTwoMonitors(final String twoMonitors) {
        this.twoMonitors = twoMonitors;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(oneMonitor);
        hash = 47 * hash + Objects.hashCode(twoMonitors);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MonitorsConfig)) {
            return false;
        }
        final MonitorsConfig other = (MonitorsConfig) obj;
        return Objects.equals(twoMonitors, other.twoMonitors) && Objects.equals(oneMonitor, other.oneMonitor);
    }

    @Override
    public String getTitle() {
        return oneMonitor;
    }

    @Override
    public String getDescription() {
        return twoMonitors + " | " + twoMonitors;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("<html>");
        b.append(getTitle()).append("<br>").append(getDescription()).append("</html>");
        return b.toString();
    }

}
