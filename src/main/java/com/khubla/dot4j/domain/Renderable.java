package com.khubla.dot4j.domain;

import java.io.*;

public interface Renderable {
	void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException;
}
