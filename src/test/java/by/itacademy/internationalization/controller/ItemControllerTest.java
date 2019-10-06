package by.itacademy.internationalization.controller;

import by.itacademy.internationalization.dto.ItemDto;
import by.itacademy.internationalization.entity.enam.Language;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testEn() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item")
                .param("code", "1212")
                .param("language", Language.EN.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        ItemDto dto = objectMapper.readValue(json, ItemDto.class);

        assertEquals("Phone", dto.getItemName());
        assertThat(dto.getAttributeNames(), containsInAnyOrder("Manufacture", "Screen Size", "Model"));
    }

    @Test
    public void testFr() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item")
                .param("code", "1212")
                .param("language", Language.FR.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        ItemDto dto = objectMapper.readValue(json, ItemDto.class);

        assertEquals("Le téléphone", dto.getItemName());
        assertThat(dto.getAttributeNames(), containsInAnyOrder("La production", "Screen Size", "Le modèle"));
    }

    @Test
    public void testRu() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item")
                .param("code", "1212")
                .param("language", Language.RU.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        ItemDto dto = objectMapper.readValue(json, ItemDto.class);

        assertEquals("Телефон", dto.getItemName());
        assertThat(dto.getAttributeNames(), containsInAnyOrder("Производство", "Screen Size", "Модель"));
    }

    @Test
    public void testKz() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item")
                .param("code", "1212")
                .param("language", Language.KZ.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        ItemDto dto = objectMapper.readValue(json, ItemDto.class);

        assertEquals("Тел", dto.getItemName());
        assertThat(dto.getAttributeNames(), containsInAnyOrder("Өндіріс", "Screen Size", "Улгісі"));
    }
}