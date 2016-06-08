package com.fuglu.futures;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturePlayground
{
	public void start() throws Exception
	{
		final CompletableFuture<String> future1 = getCompletableFuture("future1", 1000);
		final CompletableFuture<String> future2 = getCompletableFuture("future2", 5000);
		final CompletableFuture<String> future3 = getCompletableFuture("future3", 2000);

		System.out.println("Initialized futures");

		System.out.println("future1 returned: " + future1.get());
		System.out.println("future2 returned: " + future2.get());
		System.out.println("future3 returned: " + future3.get());
	}

	private CompletableFuture<String> getCompletableFuture(final String name, final int millis)
	{
		return CompletableFuture.supplyAsync(() ->
		{
			try
			{
				Thread.sleep(millis);
			}
			catch (final Exception e)
			{
			}

			return name;
		});
	}
}
