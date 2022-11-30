package ua.goit.dev6.service.converter;


import ua.goit.dev6.model.dao.ProjectDao;
import ua.goit.dev6.model.dto.ProjectDto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class ProjectConverter implements Converter<ProjectDto, ProjectDao> {
    @Override
    public ProjectDto from(ProjectDao projectDao) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(projectDao.getId());
        projectDto.setName(projectDao.getName());
        projectDto.setDescriptions(projectDao.getDescriptions());
        projectDto.setCost(projectDao.getCost());
        LocalDate date = Instant.ofEpochMilli(projectDao.getDate()).atZone(ZoneId.systemDefault()).toLocalDate();
        projectDto.setDate(date);
        return projectDto;
    }

    @Override
    public ProjectDao to(ProjectDto projectDto) {
        ProjectDao projectDao = new ProjectDao();
        projectDao.setId(projectDto.getId());
        projectDao.setName(projectDto.getName());
        projectDao.setDescriptions(projectDto.getDescriptions());
        projectDao.setCost(projectDto.getCost());
        Instant instant = projectDto.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant();
        projectDao.setDate(instant.toEpochMilli());
        return projectDao;
    }
}
