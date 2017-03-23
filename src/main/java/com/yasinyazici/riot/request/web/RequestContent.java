package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * <p>Makes it possible to read the reply ({@link InputStream}) of the riot server handled by {@link Request#makeRequest()}</p>
 *
 * @author Yasin
 */
public class RequestContent {

    /**
     * Represents the {@link InputStream} incoming from the Riot's offical REST-API
     */
    private InputStream stream;


    /**
     * Creates a new {@link RequestContent} instance
     * @param stream the {@link InputStream} to rely the {@link RequestContent} on
     */
    public RequestContent(InputStream stream) {
        this.stream = stream;
    }


    /**
     * Creates a {@link BufferedReader}, concluding
     * the lines into a {@link String} array, then casting {@link Collectors#joining()} with {@link System#lineSeparator} as parameter
     * concenating each {@link String} in the lines array of {@code stream} resulting into a return of a String displaying the whole
     * lines
     *
     * @return the raw properties of {@link InputStream stream} converted to a String
     * @throws DataException thrown when the Data is invalid
     */
    public String getContent() throws DataException {
        if (stream == null) {
            throw new DataException("Stream is null! (Invalid data?)");
        }
        return new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
