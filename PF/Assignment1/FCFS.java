public class FCFS {
	public static int[][] fcfs(int arrival_time[], int job_size[]) {
		int[] job_wait_time = new int[arrival_time.length];
		int[] job_start_at = new int[arrival_time.length];
		int[] job_finished_at = new int[arrival_time.length];
		int[][] result = new int[arrival_time.length][5];
		job_wait_time[0] = 0;
		job_start_at[0] = arrival_time[0];
		for (int count = 0; count < arrival_time.length - 1; count++) {
			job_finished_at[count] = job_start_at[count] + job_size[count] - 1;
			if (arrival_time[count + 1] < job_finished_at[count]) {
				job_wait_time[count + 1] = job_finished_at[count]
						- arrival_time[count + 1] + 1;
				job_start_at[count + 1] = job_finished_at[count] + 1;
			} else {
				job_wait_time[count + 1] = 0;
				job_start_at[count + 1] = arrival_time[count + 1];
			}

		}
		job_finished_at[arrival_time.length - 1] = job_start_at[arrival_time.length - 1]
				+ job_size[arrival_time.length - 1] - 1;
		for (int count = 0; count < arrival_time.length; count++) {
			result[count][0] = count + 1;
			result[count][1] = arrival_time[count];
			result[count][2] = job_wait_time[count];
			result[count][3] = job_start_at[count];
			result[count][4] = job_finished_at[count];
		}

		return result;
	}

}
