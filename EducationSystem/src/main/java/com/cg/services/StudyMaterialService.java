package com.cg.services;

import java.util.List;

import com.cg.entities.StudyMaterial;

public interface StudyMaterialService {

	public StudyMaterial saveStudyMaterial(StudyMaterial studyMaterial);

	public StudyMaterial getStudyMaterialById(int materialId);

	public List<StudyMaterial> getAllStudyMaterials();

	public StudyMaterial updateStudyMaterial(StudyMaterial studyMaterial);

	public void deleteStudyMaterialById(int materialId);

}
