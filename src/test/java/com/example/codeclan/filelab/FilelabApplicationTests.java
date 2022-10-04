package com.example.codeclan.filelab;

import com.example.codeclan.filelab.models.File;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilelabApplicationTests {


	File file;

	@Test
	void contextLoads() {
		file = new File("myFile", ".txt", 10 );

	}

}
