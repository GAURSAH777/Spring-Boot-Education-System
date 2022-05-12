package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entities.StudyMaterial;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.StudyMaterialRepository;

@Service
public class StudyMaterialServiceImpl implements StudyMaterialService {

	@Autowired
	private StudyMaterialRepository studyMaterialRepo;

	@Override
	public StudyMaterial saveStudyMaterial(StudyMaterial studyMaterial) {
		StudyMaterial savedStudyMaterial = studyMaterialRepo.save(studyMaterial);
		return savedStudyMaterial;
	}

	@Override
	public StudyMaterial getStudyMaterialById(int materialId) {
		Optional<StudyMaterial> optionalStudyMaterial = studyMaterialRepo.findById(materialId);
		if (optionalStudyMaterial == null)
			throw new ResourceNotFoundException("StudyMaterial Not found with id : " + materialId);
		StudyMaterial studyMaterial = optionalStudyMaterial.get();
		return studyMaterial;
	}

	@Override
	public List<StudyMaterial> getAllStudyMaterials() {
		List<StudyMaterial> studyMaterials = studyMaterialRepo.findAll();
		return studyMaterials;
	}

	@Override
	public StudyMaterial updateStudyMaterial(StudyMaterial studyMaterial) {
		StudyMaterial updatedStudyMaterial = getStudyMaterialById(studyMaterial.getMaterialId());
		updatedStudyMaterial = studyMaterialRepo.save(studyMaterial);
		return updatedStudyMaterial;
	}

	@Override
	public void deleteStudyMaterialById(int materialId) {
		StudyMaterial studyMaterial = getStudyMaterialById(materialId);
		studyMaterialRepo.delete(studyMaterial);
	}

}
