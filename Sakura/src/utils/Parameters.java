package utils;

public class Parameters {
	/**
	 * global parameters stands for the orders status
	 */
	public final static String BOOKING = "booking";
	public final static String ACTIVE = "active";
	public final static String FINISH = "finish";
	public final static String CANCEL = "cancel";
	/**
	 * The global settings for number of retrying to reconnect the database
	 * if the request was rejected.
	 */
	public final static int num_of_retry = 3;
}
