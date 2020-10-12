package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.VO.JobsVO;
import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.dao.JobsDaoI;

public class JobsService implements JobsServiceI{

	@Override
	public List<JobsVO> getAllJobs() {
		JobsDaoI jobsDao = new JobsDao();
		return jobsDao.getAllJobs();
	}

}
