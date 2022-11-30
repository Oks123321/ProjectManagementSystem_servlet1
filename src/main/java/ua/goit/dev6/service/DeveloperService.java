package ua.goit.dev6.service;

import ua.goit.dev6.model.dao.DeveloperDao;
import ua.goit.dev6.model.dto.DeveloperDto;
import ua.goit.dev6.repository.DeveloperRepository;
import ua.goit.dev6.repository.ProjectRepository;
import ua.goit.dev6.repository.SkillRepository;
import ua.goit.dev6.service.converter.DeveloperConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeveloperService {
    private final DeveloperRepository developerRepository;
    private final SkillRepository skillRepository;
    private final DeveloperConverter developerConverter;
    private final ProjectRepository projectRepository;

    public DeveloperService(DeveloperRepository developerRepository, SkillRepository skillRepository,
                            ProjectRepository projectRepository, DeveloperConverter developerConverter) {
        this.developerRepository = developerRepository;
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
        this.developerConverter = developerConverter;
    }

    public DeveloperDto create(DeveloperDto developerDto) {
        DeveloperDao developerDao = developerRepository.save(developerConverter.to(developerDto));
        return developerConverter.from(developerDao);
    }

    public Optional<DeveloperDto> findById(Long id) {
        Optional<DeveloperDao> developerDao = developerRepository.findById(id);
        return developerDao.map(developerConverter::from);
    }
    public List<DeveloperDto> findAll(){
        return developerRepository.findAll().stream()
                .map(developerConverter::from)
                .collect(Collectors.toList());
    }

    public DeveloperDto update(DeveloperDto developerDto) {
        DeveloperDao developerDao = developerRepository.update(developerConverter.to(developerDto));
        return developerConverter.from(developerDao);
    }

    public void delete(DeveloperDto developerDto) {
        developerRepository.delete(developerConverter.to(developerDto));
    }
    public List<DeveloperDto> findByProjectId(Long id){
        return projectRepository.findById(id).orElseThrow(RuntimeException::new)
                .getDevelopers().stream()
                .map(developerConverter::from)
                .collect(Collectors.toList());
    }

    public List<DeveloperDto> findBySkillId(Long id) {
        return skillRepository.findById(id).orElseThrow(RuntimeException::new)
                .getDevelopers().stream()
                .map(developerConverter::from)
                .collect(Collectors.toList());
    }

}
