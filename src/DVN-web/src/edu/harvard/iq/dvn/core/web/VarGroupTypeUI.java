/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.harvard.iq.dvn.core.web;


import edu.harvard.iq.dvn.core.visualization.VarGroupType;

/**
 *
 * @author skraffmiller
 */
public class VarGroupTypeUI {
    private VarGroupType varGroupType;
    private boolean enabled;
    private boolean editMode;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public VarGroupType getVarGroupType() {
        return varGroupType;
    }

    public void setVarGroupType(VarGroupType varGroupType) {
        this.varGroupType = varGroupType;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }


}
