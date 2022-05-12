package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.StudyMaterial;
import com.cg.services.StudyMaterialService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/study")
public class StudyMaterialController {
	@Autowired
	private StudyMaterialService studyMaterialService;

	@GetMapping("/all")
	public List<StudyMaterial> fetchAllStudyMaterial() {

		List<StudyMaterial> studyMaterial = studyMaterialService.getAllStudyMaterials();
		return studyMaterial;
	}

	@PostMapping("/save")
	public ResponseEntity<StudyMaterial> addStudyMaterial(@Valid @RequestBody StudyMaterial studyMaterial) {

		StudyMaterial newStudyMaterial = studyMaterialService.saveStudyMaterial(studyMaterial);
		ResponseEntity<StudyMaterial> responseEntity = new ResponseEntity<>(newStudyMaterial, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchStudyMaterialById(@PathVariable("id") int materialId) {

		ResponseEntity<?> responseEntity = null;
		StudyMaterial studyMaterial = studyMaterialService.getStudyMaterialById(materialId);
		responseEntity = new ResponseEntity<>(studyMaterial, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudyMaterialById(@PathVariable("id") int materialId) {

		ResponseEntity<String> responseEntity = null;
		studyMaterialService.deleteStudyMaterialById(materialId);
		responseEntity = new ResponseEntity<>("StudyMaterial deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateStudyMaterial(@RequestBody StudyMaterial studyMaterial) {

		ResponseEntity<Object> responseEntity = null;
		StudyMaterial updatedStudyMaterial = studyMaterialService.updateStudyMaterial(studyMaterial);
		responseEntity = new ResponseEntity<>(updatedStudyMaterial, HttpStatus.OK);
		return responseEntity;
	}

}
