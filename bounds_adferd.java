for (int i = 0; i < invaders.length; i++) {
	if (invaders[i].getBounds().intersects(gameFrame)) {
		xDir = !xDir;
		break;
	}
}