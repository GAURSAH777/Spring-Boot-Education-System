package com.cg.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entities.StudyMaterial;
import com.cg.repositories.StudyMaterialRepository;
import com.cg.services.StudyMaterialServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)

@SpringBootTest
public class StudyMaterialServiceTest {
	@InjectMocks
	private StudyMaterialServiceImpl studyService;

	@MockBean
	private StudyMaterialRepository studyRepo;

	@Test
	public void testAddMaterial() {
		StudyMaterial stud = new StudyMaterial();
		stud.setMaterialType("Introduction to testing");

		Mockito.when(studyRepo.save(stud)).thenReturn(stud);
		assertThat(studyService.saveStudyMaterial(stud)).isEqualTo(stud);
	}

	@Test
	public void testViewMaterial() {
		StudyMaterial stud1 = new StudyMaterial();
		stud1.setMaterialType("Testing tutorial 1");

		StudyMaterial stud2 = new StudyMaterial();
		stud2.setMaterialType("Testing tutorial 2");

		List<StudyMaterial> studList = new ArrayList<StudyMaterial>();
		studList.add(stud1);
		studList.add(stud2);

		Mockito.when(studyRepo.findAll()).thenReturn(studList);
		assertThat(studyService.getAllStudyMaterials()).isEqualTo(studList);
	}

	@Test
	public void testDelete() {
		StudyMaterial stud = new StudyMaterial();
		stud.setMaterialId(36);
		stud.setMaterialType("Spring Data JPA");
		Mockito.when(studyRepo.getOne(36)).thenReturn(stud);
		Mockito.when(studyRepo.existsById(stud.getMaterialId())).thenReturn(false);
		assertFalse(studyRepo.existsById(stud.getMaterialId()));

	}

}
