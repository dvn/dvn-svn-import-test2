/*
 * Dataverse Network - A web application to distribute, share and analyze quantitative data.
 * Copyright (C) 2009
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *  along with this program; if not, see http://www.gnu.org/licenses
 * or write to the Free Software Foundation,Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package edu.harvard.iq.dvn.ingest.statdataio.impl.plugins.util;

import java.io.*;
import java.util.logging.*;


import edu.harvard.iq.dvn.ingest.org.thedata.statdataio.metadata.*;
import edu.harvard.iq.dvn.ingest.org.thedata.statdataio.data.*;

/**
 * This is a reader for a CSV (character-separated values) data file.
 * Note that this is not a fully-functional data file reader plugin
 * (it doesn't extend StatDataFileReader), this class only reads the
 * data (i.e., DataTable) from a plain text file. The metadata describing
 * the data set and its variables should be supplied elsewhere.
 * (For example, via an SPSS control card; the assumption is that in the
 * future we'll be offering support for other data-less metadata declarations,
 * then all these different readers will be able to use this data reader)
 *
 * @author Leonid Andreev
 *
 */
public class CSVFileReader implements java.io.Serializable {
    private char delimiterChar='\t';

    private static Logger dbgLog =
       Logger.getLogger(CSVFileReader.class.getPackage().getName());


    public CSVFileReader () {
    }

    public CSVFileReader (char delimiterChar) {
        this.delimiterChar = delimiterChar;
    }

    public DataTable read(BufferedReader csvReader, SDIOMetadata smd) throws IOException {
        DataTable csvData = new DataTable();
        Object[][] dataTable = null;
        int varQnty = new Integer(smd.getFileInformation().get("varQnty").toString());

        String line;
        String[] valueTokens = new String[varQnty];
        int lineCounter = 0;

        int[] variableTypeList = smd.getVariableTypeMinimal();

        while ((line = csvReader.readLine()) != null) {
            // chop the line:
            line = line.replaceFirst("[ \t\n]*$", "");
            valueTokens = line.split(""+delimiterChar, 0);

            for ( int i = 0; i < varQnty; i++ ) {

                if (variableTypeList[i] == 0) {
                    // Numeric value:
                    dataTable[lineCounter][i] = new Double(valueTokens[i]);
                } else {
                    // String. Adding to the table as is.
                    dataTable[lineCounter][i] = valueTokens[i];
                }
            }
            lineCounter++;
        }

        csvData.setData(dataTable);
        return csvData;
    }

}