package com.v5ent.xoss.trace;

public class TraceRunnable implements Runnable{
	
	private Runnable wrappedRunnable;
	private Span currentSpan;
	
	public TraceRunnable(Runnable wrappedRunnable) {
		this.wrappedRunnable = wrappedRunnable;
		this.currentSpan = Tracer.getCurrentSpan();
	}
	

	public Span getCurrentSpan() {
		return currentSpan;
	}


	@Override
	public void run() {
		if(null != getCurrentSpan())
			Tracer.setCurrentSpan(getCurrentSpan());
		wrappedRunnable.run();
	}

}
