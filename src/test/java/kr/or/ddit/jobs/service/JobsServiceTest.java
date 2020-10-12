package kr.or.ddit.jobs.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.VO.JobsVO;

public class JobsServiceTest {

	@Test
	public void JobsServiceTest() {
		/***Given***/
		JobsServiceI jobsService = new JobsService();
		
		/***When***/
		List<JobsVO> jobsList = jobsService.getAllJobs();

		/***Then***/
		assertEquals("AD_VP",jobsList.get(1).getJob_id());
	}
}
